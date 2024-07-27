import ImageUpload from "../components/ImageServicePlayground/ImageUpload";
import RetrieveImagePreview from "../components/ImageServicePlayground/RetrieveImagePreview";
import { BaseLayout } from "../layouts/BaseLayout";

const ImageServicePlaygroundView = () => {
  return (
    <BaseLayout
      mainContent={
        <>
          <h1>ImageServicePlaygroundView</h1>
          <hr />
          <div className="flex flex-row space-x-2">
            <ImageUpload />
            <RetrieveImagePreview />
          </div>
        </>
      }
    />
  );
};

export default ImageServicePlaygroundView;
