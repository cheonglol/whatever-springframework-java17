import React from "react";
import { toast } from "react-toastify";

interface Props {
  imageSrc: string;
}

const RetrieveImagePreview = ({ imageSrc }: Props) => {
  if (!imageSrc.includes(".")) return <em className="mt-4 text-sm block">Maybe fill up the orange input? (at least a '.' in the input?)</em>;
  return (
    <img
      onError={() => {
        toast("that shit didn't work", { theme: "colored", type: "error" });
      }}
      className="max-w-[30rem]"
      src={imageSrc}
    />
  );
};

export default React.memo(RetrieveImagePreview);
