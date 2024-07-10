import React from "react";

interface Props {
  imageSrc: string;
}

const RetrieveImagePreview = ({ imageSrc }: Props) => {
  if (!imageSrc.includes(".")) return <em className="mt-4 text-sm block">Maybe fill up the orange input? (at least a '.' in the input?)</em>;
  return <img className="" src={imageSrc} />;
};

export default React.memo(RetrieveImagePreview);
