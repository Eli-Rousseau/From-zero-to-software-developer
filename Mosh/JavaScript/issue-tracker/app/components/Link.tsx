import NextLink from "next/link";
import { Link as RadixUILink } from "@radix-ui/themes";

interface Props {
  href: string;
  children: string;
}

function Link({ href, children }: Props) {
  return (
    <NextLink href={href} passHref legacyBehavior>
      <RadixUILink>{children}</RadixUILink>
    </NextLink>
  );
}

export default Link;
