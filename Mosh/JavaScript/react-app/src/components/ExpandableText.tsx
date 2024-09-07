import { useState } from "react";

interface Props {
  expandableLength?: number;
  children: string;
}

function ExpandableText({ expandableLength = 50, children }: Props) {
  const [isExpanded, setExpandedState] = useState(false);
  const handleClick = function () {
    setExpandedState(!isExpanded);
  };
  return (
    <>
      <span>
        {isExpanded
          ? children.substring(0, expandableLength) + "..."
          : children}
      </span>
      <button onClick={handleClick}>{isExpanded ? "More" : "Less"}</button>
    </>
  );
}

export default ExpandableText;
