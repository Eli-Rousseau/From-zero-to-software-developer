import prisma from "@/prisma/client";
import { Box, Flex, Grid } from "@radix-ui/themes";
import { notFound } from "next/navigation";
import EditIssueButton from "./EditIssueButton";
import IssueDetails from "./IssueDetails";
import DeleteIssueButton from "./DeleteIssueButton";
import AssigneeSelect from "./AssigneeSelect";
import { cache } from "react";

const fetchUser = cache((issueId: number) =>
  prisma.issue.findUnique({ where: { id: issueId } })
);

interface Props {
  params: { id: string };
}

async function IssueDetailPage({ params }: Props) {
  const issue = await fetchUser(parseInt(params.id));

  if (!issue) notFound();

  return (
    <Grid columns={{ initial: "1", sm: "5" }} gap="5">
      <Box className="md:col-span-4">
        <IssueDetails issue={issue}></IssueDetails>
      </Box>
      <Box>
        <Flex direction="column" gap="4">
          <AssigneeSelect issue={issue}></AssigneeSelect>
          <EditIssueButton issueId={issue.id}></EditIssueButton>
          <DeleteIssueButton issueId={issue.id}></DeleteIssueButton>
        </Flex>
      </Box>
    </Grid>
  );
}

export async function generateMetadata({ params }: Props) {
  const issue = await fetchUser(parseInt(params.id));

  return {
    title: issue?.title,
    description: `Details of issue ${issue?.id}`,
  };
}

export default IssueDetailPage;
