import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import { STANDARD_TOAST_OPTIONS } from "../../constant/ToastOptions";
import { Card } from "primereact/card";
import { InputText } from "primereact/inputtext";

const RetrieveImagePreview = () => {
  const serviceProviderAddr = "http://localhost:8080";
  const retrievalPath = (param?: string) => (param ? `/images/retrieve?uniqueIdentifier=${param}` : "/images/retrieve?uniqueIdentifier=");
  const [retrieveFilename, setRetrieveFilename] = useState<string>("");

  const handleRetrievalSample = async (e: React.ChangeEvent<HTMLInputElement>) => {
    if (e.target.value.length !== 36) return;
    toast("🔍 attempting to fetch image...", STANDARD_TOAST_OPTIONS("info"));
    await new Promise((resolve) => setTimeout(resolve, 1500));
    setRetrieveFilename(`${serviceProviderAddr}${retrievalPath(e.target.value)}`);
  };

  useEffect(() => {}, [retrieveFilename]);

  return (
    <Card className="flex-[2.2] shadow-sm">
      <strong>retrieval endpoint</strong>
      <pre>
        {serviceProviderAddr + retrievalPath() + `"`}
        <InputText className="border border-orange-400 p-2 text-orange-400 inline-block font-bold text-sm" onChange={handleRetrievalSample} />"
      </pre>
      <img
        onError={(event) => {
          toast("that shit didn't work", STANDARD_TOAST_OPTIONS("error"));
        }}
        className="max-w-[30rem] inline-block"
        src={retrievalPath(retrieveFilename)}
      />
    </Card>
  );
};

export default React.memo(RetrieveImagePreview);
