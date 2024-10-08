import { Box } from "@chakra-ui/react";
import { ReactNode } from "react";

interface Props {
  children: ReactNode;
}

function GameCardContainer({ children }: Props) {
  return (
    <Box
      borderRadius="10px"
      overflow="hidden"
      _hover={{
        transform: "scale(1.03)",
        transition: "transform 0.15s ease-in"
      }}
    >
      {children}
    </Box>
  );
}

export default GameCardContainer;
