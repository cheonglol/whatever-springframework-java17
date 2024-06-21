import { Card } from "primereact/card";
import { useState } from "react";
import { BaseLayout } from "../layouts/BaseLayout";
import { uploadImage } from "../api/ImageServiceUpload_API";

const ImageServicePlaygroundView = () => {
  const [previewSrc, setPreviewSrc] = useState<string | null>(null);
  const [fileName, setFileName] = useState<string>("");

  const handlePreviewImageUpload = (e: React.ChangeEvent<HTMLInputElement>) => {
    if (e.target.files && e.target.files.length > 0) {
      const file = e.target.files[0];
      const reader = new FileReader();
      reader.onloadend = () => {
        setPreviewSrc(reader.result as string);
      };
      reader.readAsDataURL(file);
      setFileName(file.name);
    }
  };

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    if (!previewSrc) {
      alert("Please select an image first.");
      return;
    }

    // Extract base64 string and use the stored filename
    const base64data = previewSrc?.split(",")[1]; // Assuming previewSrc is a data URL
    // Call the modified uploadImage function
    uploadImage(base64data, fileName);
  };

  return (
    <BaseLayout
      mainContent={
        <>
          <h1>ImageServicePlaygroundView</h1>
          <hr />
          <form onSubmit={handleSubmit}>
            <Card className="shadow-sm w-fit px-4 transition-all">
              {previewSrc ? <img className="max-w-[30rem]" src={previewSrc} alt="Selected" /> : <div className="">Please select an image for preview.</div>}
              <input className="mt-4 p-2 mr-4" type="file" placeholder="Image Path" onChange={handlePreviewImageUpload} />
            </Card>
            <button className="bg-slate-100 text-blue-600" type="submit">
              Submit
            </button>
          </form>
        </>
      }
    />
  );
};

export default ImageServicePlaygroundView;
