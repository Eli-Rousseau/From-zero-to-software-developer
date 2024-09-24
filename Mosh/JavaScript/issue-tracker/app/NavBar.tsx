"use client";

import Link from "next/link";
import { usePathname } from "next/navigation";
import { RiBugFill } from "react-icons/ri";
import classNames from "classnames";

function NavBar() {
  const currentPath = usePathname();

  const links = [
    { label: "Dashboard", href: "/" },
    { label: "Issues", href: "/issues/list" },
  ];

  return (
    <nav className="flex space-x-6 border-b mb-5 px-5 h-14 items-center">
      <Link href="/">
        <RiBugFill></RiBugFill>
      </Link>
      <ul className="flex space-x-6">
        {links.map((link) => (
          <Link
            className={classNames({
              "text-zinc-900": link.href === currentPath,
              "text-zinc-500": link.href !== currentPath,
              "hover:text-zinc-800 transition-colors": true,
            })}
            href={link.href}
            key={link.href}
          >
            {link.label}
          </Link>
        ))}
      </ul>
    </nav>
  );
}

export default NavBar;
