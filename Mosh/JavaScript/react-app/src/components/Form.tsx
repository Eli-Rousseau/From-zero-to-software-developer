import { useState } from "react";

function Form() {
  const [person, setPerson] = useState({
    name: "",
    age: 0,
  });
  return (
    <>
      <div className="mb-3">
        <label htmlFor="name" className="form-label">
          Name
        </label>
        <input
          onChange={(event) =>
            setPerson({ ...person, name: event.target.value })
          }
          id="name"
          type="text"
          className="form-control"
          placeholder="Enter name.."
        />
      </div>
      <div className="mb-3">
        <label htmlFor="Age" className="form-label">
          Age
        </label>
        <input
          onChange={(event) =>
            setPerson({ ...person, age: parseInt(event.target.value) })
          }
          id="Age"
          type="number"
          className="form-control"
          placeholder="Enter age.."
        />
      </div>
      <button className="btn btn-primary" type="submit">
        Submit
      </button>
    </>
  );
}

export default Form;
