import { Card } from "primereact/card";
import { useState, useEffect } from "react";
import { BaseLayout } from "../layouts/BaseLayout";
import { uploadImage } from "../api/ImageServiceUpload_API";
import { Button } from "primereact/button";
import { InputText } from "primereact/inputtext";
import RetrieveImagePreview from "../components/ImageServicePlayground/RetrieveImagePreview";

// TEMPORARY CONST - TODO: MOVE THIS SHIT INTO ENV OR SOMETHING

const ImageServicePlaygroundView = () => {
  const serviceProviderAddr = "http://localhost:8080";
  const retrievalPath = (param?: string) => (param ? `/images/retrieve?filename=${param}` : "/images/retrieve?filename=");

  const [uploadPreviewSrc, setUploadPreviewSrc] = useState<string | null>(null);
  const [fileName, setFileName] = useState<string>("");
  const [retrieveFilename, setRetrieveFilename] = useState<string>("");

  const handleImageUploadPreview = (e: React.ChangeEvent<HTMLInputElement>) => {
    if (e.target.files && e.target.files.length > 0) {
      const file = e.target.files[0];
      const reader = new FileReader();
      reader.onloadend = () => {
        setUploadPreviewSrc(reader.result as string);
      };
      reader.readAsDataURL(file);
      setFileName(file.name);
    }
  };

  const handleUploadSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    if (!uploadPreviewSrc) {
      alert("Please select an image first.");
      return;
    }

    // Extract base64 string and use the stored filename
    const base64data = uploadPreviewSrc?.split(",")[1]; // Assuming previewSrc is a data URL
    // Call the modified uploadImage function
    uploadImage(base64data, fileName);
  };

  const handleRetrievalSample = async (e: React.ChangeEvent<HTMLInputElement>) => {
    if (!e.target.value.includes(".")) return;
    if (e.target.value.split(".")[1].length <= 2) return;
    await new Promise((resolve) => setTimeout(resolve, 1500));

    setRetrieveFilename(`${serviceProviderAddr}${retrievalPath(e.target.value)}`);
  };

  useEffect(() => {}, [retrieveFilename]);

  return (
    <BaseLayout
      mainContent={
        <>
          <h1>ImageServicePlaygroundView</h1>
          <hr />
          <div className="flex flex-row space-x-2">
            <Card className="flex-1 shadow-sm w-fit px-4 transition-all">
              <form onSubmit={handleUploadSubmit}>
                {uploadPreviewSrc ? <img className="max-w-[30rem]" src={uploadPreviewSrc} alt="Selected" /> : <div className="">Please select an image for preview.</div>}
                <input className="mt-4 p-2 mr-4" type="file" placeholder="Image Path" onChange={handleImageUploadPreview} />
                <Button className="p-2 bg-blue-600 text-white" raised type="submit">
                  Submit
                </Button>
              </form>
            </Card>
            <Card className="flex-[2.2] shadow-sm">
              <strong>retrieval endpoint</strong>
              <pre>
                {serviceProviderAddr}
                {retrievalPath()}"
                <InputText className="border border-orange-400 p-2 text-orange-400 inline-block font-bold text-sm" onChange={handleRetrievalSample} />"
                <RetrieveImagePreview imageSrc={retrieveFilename} />
              </pre>
            </Card>
          </div>
        </>
      }
    />
  );
};

export default ImageServicePlaygroundView;
