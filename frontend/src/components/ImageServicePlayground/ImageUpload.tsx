import { Card } from "primereact/card";
import React, { useState } from "react";
import { STANDARD_TOAST_OPTIONS } from "../../constant/ToastOptions";
import { toast } from "react-toastify";
import { uploadImage } from "../../api/ImageServiceUpload_API";
import { Button } from "primereact/button";

const ImageUpload = () => {
  const [uploadPreviewSrc, setUploadPreviewSrc] = useState<string | null>(null);
  const [fileName, setFileName] = useState<string>("");

  const handleUploadSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    if (!uploadPreviewSrc) {
      toast("Please select an image first.", STANDARD_TOAST_OPTIONS("info"));
      return;
    }

    // Extract base64 string and use the stored filename
    const base64data = uploadPreviewSrc?.split(",")[1]; // Assuming previewSrc is a data URL
    // Call the modified uploadImage function
    uploadImage(base64data, fileName);
  };

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

  return (
    <Card className="flex-1 shadow-sm w-fit px-4 transition-all">
      <form onSubmit={handleUploadSubmit}>
        {uploadPreviewSrc ? <img className="max-w-[30rem]" src={uploadPreviewSrc} alt="Selected" /> : <div className="">Please select an image for preview.</div>}
        <input className="mt-4 p-2 mr-4" type="file" placeholder="Image Path" onChange={handleImageUploadPreview} />
        <Button className="p-2 bg-blue-600 text-white" raised type="submit">
          Submit
        </Button>
      </form>
    </Card>
  );
};

export default ImageUpload;
