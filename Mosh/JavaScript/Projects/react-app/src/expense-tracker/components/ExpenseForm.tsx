import categories from "./categories";
import { z } from "zod";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";

interface Props {
    onSubmit: (data: ExpenseFormData) => void
}

const schema = z.object({
  Description: z
    .string()
    .min(3, { message: "Description should be at least 3 characters." })
    .max(50, { message: "Description should be at most 50 characters." }),
  Amount: z
    .number({ invalid_type_error: "Amount is required." })
    .min(0.01)
    .max(1_000_000),
  Category: z.enum(categories, {
    errorMap: () => ({ message: "Category is required." }),
  }),
});

type ExpenseFormData = z.infer<typeof schema>;

function ExpenseForm( {onSubmit} : Props) {
  const {
    register,
    handleSubmit,
    reset,
    formState: { errors },
  } = useForm<ExpenseFormData>({
    resolver: zodResolver(schema),
  });
  return (
    <form onSubmit={handleSubmit(data => {
        onSubmit(data);
        reset();
    })}>
      <div className="mb-3">
        <label htmlFor="Description" className="form-label">
          Description
        </label>
        <input
          {...register("Description")}
          id="Description"
          type="text"
          className="form-control"
        />
        {errors.Description && (
          <p className="text-danger">{errors.Description.message}</p>
        )}
      </div>
      <div className="mb-3">
        <label htmlFor="Amount" className="form-label">
          Amount
        </label>
        <input
          {...register("Amount", { valueAsNumber: true })}
          id="Amount"
          type="number"
          className="form-control"
        />
        {errors.Amount && (
          <p className="text-danger">{errors.Amount.message}</p>
        )}
      </div>
      <div className="mb-3">
        <label htmlFor="Category" className="form-label">
          Category
        </label>
        <select {...register("Category")} id="Category" className="form-select">
          <option></option>
          {categories.map((category) => (
            <option key={category} value={category}>
              {category}
            </option>
          ))}
        </select>
        {errors.Category && (
          <p className="text-danger">{errors.Category.message}</p>
        )}
      </div>
      <button className="btn btn-primary">Submit</button>
    </form>
  );
}

export default ExpenseForm;
