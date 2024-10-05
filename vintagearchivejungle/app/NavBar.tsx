"use client";

import { Bevan } from "@next/font/google";
import Link from "next/link";
import { useState } from "react";
import { AiOutlineUser } from "react-icons/ai";
import { IoChevronDown } from "react-icons/io5";
import { LiaShoppingBagSolid } from "react-icons/lia";
import { RiMenuFill } from "react-icons/ri";

const bevan = Bevan({ subsets: ["latin"], weight: ["400"] });

const NavBar = () => {
  // State to manage the chevron toggle
  const [isMenuOpen, setMenuOpen] = useState(false);
  const [isCartOpen, setCartOpen] = useState(false);

  // Example cart item count (you can pass this dynamically)
  const cartItemCount = 5; // Example value

  return (
    <div className="grid grid-cols-3 my-3 md:my-6 items-center w-full">
      {/* Left part: expandable menu */}
      <div
        title="Menu"
        className="flex justify-start items-center gap-x-0.5 ml-3 md:ml-5 justify-self-start md:scale-110 hover:cursor-pointer group"
        onClick={() => setMenuOpen(!isMenuOpen)} // Toggle menu chevron
      >
        <RiMenuFill size={30} />
        <IoChevronDown
          className={`transition-transform duration-200 ${
            isMenuOpen ? "translate-y-1" : ""
          }`}
        />
      </div>

      {/* Center part: brand name */}
      <div
        title="Home"
        className={`${bevan.className} text-xl md:text-3xl max-w-[150px] flex text-center justify-self-center md:scale-110 hover:cursor-pointer`}
      >
        <Link href="/">
          <p>Vintage Archive Jungle</p>
        </Link>
      </div>

      {/* Right part: basket and user */}
      <div className="flex justify-end items-center gap-x-1 md:gap-x-3 mr-3 md:mr-5 justify-self-end md:scale-110">
        {/* Shopping Cart with Badge */}
        <div
          title="Shopping Cart"
          className="relative flex justify-center items-center hover:cursor-pointer group"
          onClick={() => setCartOpen(!isCartOpen)} // Toggle cart chevron
        >
          {/* Cart Icon */}
          <LiaShoppingBagSolid size={30} />

          {/* Cart Item Count Badge */}
          {cartItemCount > 0 && (
            <span className="absolute top-0 right-5 w-4 h-4 bg-red-600 text-white text-xs flex items-center justify-center rounded-full -mt-2 -mr-2">
              {cartItemCount < 100 ? cartItemCount : ".."}
            </span>
          )}

          {/* Chevron for Cart */}
          <IoChevronDown
            className={`transition-transform duration-200 ${
              isCartOpen ? "translate-y-1" : ""
            }`}
          />
        </div>

        {/* Profile Icon */}
        <AiOutlineUser
          size={30}
          title="Profile"
          className="hover:cursor-pointer"
        />
      </div>
    </div>
  );
};

export default NavBar;
