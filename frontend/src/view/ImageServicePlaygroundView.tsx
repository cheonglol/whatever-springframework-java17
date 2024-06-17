import React from "react";
import { BaseLayout } from "../layouts/BaseLayout";
import { FileUpload } from "primereact/fileupload";

const ImageServicePlaygroundView = () => {
  return (
    <BaseLayout
      mainContent={
        <>
          <h1>ImageServicePlaygroundView</h1>
          <hr />
          <FileUpload
            name="demo[]"
            url={"/api/upload"}
            multiple
            accept="image/*"
            maxFileSize={2000000}
            emptyTemplate={<p className="m-0">Drag and drop files to here to upload.</p>}
          />
        </>
      }
    />
  );
};

export default ImageServicePlaygroundView;
