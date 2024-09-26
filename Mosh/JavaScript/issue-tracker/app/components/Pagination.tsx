"use client";

import {
  ChevronLeftIcon,
  ChevronRightIcon,
  DoubleArrowLeftIcon,
  DoubleArrowRightIcon,
} from "@radix-ui/react-icons";
import { Button, Flex, Text } from "@radix-ui/themes";
import { useRouter, useSearchParams } from "next/navigation";

interface Props {
  itemCount: number;
  pageSize: number;
  currentpage: number;
}

function Pagination({ itemCount, pageSize, currentpage }: Props) {
  const router = useRouter();
  const searchParams = useSearchParams();

  const pageCount = Math.ceil(itemCount / pageSize);
  if (pageCount <= 1) return null;

  const changePage = (page: number) => {
    const params = new URLSearchParams(searchParams);
    params.set("page", page.toString());
    router.push("?" + params.toString());
  };

  return (
    <Flex align="center" gap="2">
      <Text size="2">
        Page {currentpage} of {pageCount}
      </Text>
      <Button
        color="gray"
        variant="soft"
        disabled={currentpage === 1}
        onClick={() => changePage(1)}
      >
        <DoubleArrowLeftIcon></DoubleArrowLeftIcon>
      </Button>
      <Button
        color="gray"
        variant="soft"
        disabled={currentpage === 1}
        onClick={() => changePage(currentpage - 1)}
      >
        <ChevronLeftIcon></ChevronLeftIcon>
      </Button>
      <Button
        color="gray"
        variant="soft"
        disabled={currentpage === pageCount}
        onClick={() => changePage(currentpage + 1)}
      >
        <ChevronRightIcon></ChevronRightIcon>
      </Button>
      <Button
        color="gray"
        variant="soft"
        disabled={currentpage === pageCount}
        onClick={() => changePage(pageCount)}
      >
        <DoubleArrowRightIcon></DoubleArrowRightIcon>
      </Button>
    </Flex>
  );
}

export default Pagination;
