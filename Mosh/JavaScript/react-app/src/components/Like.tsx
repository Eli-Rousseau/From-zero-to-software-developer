import { useState } from "react";
import { IoHeartOutline } from "react-icons/io5";

interface Props {
  onClick: () => void;
}

function Like({ onClick }: Props) {
  const [liked, setLikedState] = useState(false);
  const handleClick = function () {
    setLikedState(!liked);
    onClick();
  };
  return (
    <IoHeartOutline
      color={liked ? "#ff6b81" : undefined}
      size={50}
      onClick={handleClick}
    ></IoHeartOutline>
  );
}

export default Like;
