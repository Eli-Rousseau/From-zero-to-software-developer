import { auth } from "@/auth";
import { Pencil2Icon } from "@radix-ui/react-icons";
import { Button } from "@radix-ui/themes";
import Link from "next/link";

interface Props {
  issueId: number;
}

async function EditIssueButton({ issueId }: Props) {
  const session = await auth();

  return (
    <Button disabled={session === null}>
      <Pencil2Icon></Pencil2Icon>
      {session !== null && (
        <Link href={`/issues/edit/${issueId}`}>Edit Issue</Link>
      )}
    </Button>
  );
}

export default EditIssueButton;
