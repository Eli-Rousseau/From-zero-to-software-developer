import { IoIosSearch } from "react-icons/io";

const SearchBox = () => {
  return (
    <div className="flex justify-between items-center rounded-full border-2 border-stone-400 w-full p-1 transition-shadow focus-within:shadow-lg focus-within:border-pink-400">
      <form action="/submit" className="flex w-full">
        <input
          type="text"
          id="search"
          placeholder="Search for..."
          className="flex-grow p-2 pl-4 text-sm rounded-full focus:outline-none focus:ring-0 w-full"
        />
        <button
          type="submit"
          className="p-2 text-stone-700 hover:text-stone-900 focus:outline-none focus:ring-0 flex items-center"
        >
          <IoIosSearch size={20} />
        </button>
      </form>
    </div>
  );
};

export default SearchBox;
