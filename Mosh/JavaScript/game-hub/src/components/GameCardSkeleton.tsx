import { Card, CardBody, Skeleton, SkeletonText } from "@chakra-ui/react";

function GameCardSkeleton() {
    return (
        <Card width="300px" borderRadius="10px" overflow="hidden">
            <Skeleton height="200px"></Skeleton>
            <CardBody>
                <SkeletonText></SkeletonText>
            </CardBody>
        </Card>
    );
}

export default GameCardSkeleton;