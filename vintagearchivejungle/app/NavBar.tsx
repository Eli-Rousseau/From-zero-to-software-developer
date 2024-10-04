import SearchBox from "@/components/SearchBox";
import Link from "next/link";
import { CiShoppingBasket, CiUser } from "react-icons/ci";
import { IoChevronDown } from "react-icons/io5";
import { IoIosSearch } from "react-icons/io";

const NavBar = () => {
  return (
    <div className="py-4 px-8">
      <div className="max-w-screen-2xl mx-auto flex justify-between items-center gap-x-8">
        {/* Left Section: Links */}
        <div className="flex gap-x-8 items-center">
          <Link
            href="#"
            className="text-lg font-medium whitespace-nowrap text-stone-700 hover:text-pink-400 transition-colors focus:outline-none focus:text-pink-400"
          >
            New Arrivals
          </Link>
          <div className="flex gap-x-1 justify-center items-center cursor-pointer group">
            <p className="text-lg font-medium whitespace-nowrap text-stone-700 transition-colors group-hover:text-pink-400 group-focus-within:text-pink-400">
              Shop
            </p>
            <IoChevronDown
              size={12}
              fillOpacity={0.8}
              className="text-stone-700 transition-transform transform group-hover:text-pink-400 group-hover:translate-y-1 group-focus-within:text-pink-400 group-focus-within:translate-y-1"
            />
          </div>

          <Link
            href="#"
            className="text-lg font-medium whitespace-nowrap text-stone-700 hover:text-pink-400 transition-colors focus:outline-none focus:text-pink-400"
          >
            About Us
          </Link>
        </div>

        {/* Center Section: Search Bar */}
        <div className="w-full">
          <SearchBox />
        </div>

        {/* Right Section: Basket and Profile */}
        <div className="flex items-center gap-x-8">
          <div className="flex gap-x-6 items-center">
            <div className="group relative">
              <CiShoppingBasket
                size={40}
                fillOpacity={0.8}
                title="Basket"
                className="text-stone-700 transition-transform transform hover:scale-110 hover:text-pink-400 focus:outline-none focus:text-pink-400"
              />
              <span className="absolute -top-2 -right-2 bg-red-500 text-white text-xs font-bold rounded-full h-5 w-5 flex items-center justify-center group-hover:bg-red-600">
                3
              </span>{" "}
            </div>
            <CiUser
              size={40}
              fillOpacity={0.8}
              title="Profile"
              className="text-stone-700 transition-transform transform hover:scale-110 hover:text-pink-400 focus:outline-none focus:text-pink-400"
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default NavBar;
