import { Button } from "primereact/button";
import { Skeleton } from "primereact/skeleton";
import { useEffect, useState } from "react";
import { RouteObject, useNavigate } from "react-router-dom";
import { BaseLayout } from "../layouts/BaseLayout";
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";

const LandingView = () => {
  const [getCustomRouteObjectPreview, setCustomRouteObjectPreview] = useState<RouteObject[]>([]);

  useEffect(() => {
    const loadRoutes = async () => {
      const awaitedImport = await import("../router/Router");
      setCustomRouteObjectPreview(awaitedImport.myRouteObjects);
    };
    if (getCustomRouteObjectPreview.length === 0) loadRoutes();
  }, [getCustomRouteObjectPreview]);

  return (
    <BaseLayout
      mainContent={
        <div>
          <h1>
            {"Frontend for "}
            <code>com.cheonglol.whatever-springframework-17</code>
          </h1>
          <hr className="my-4" />
          {getCustomRouteObjectPreview.length === 0 ? (
            <div className="mt-4 flex-col space-y-4">
              <Skeleton width="80%" height="4rem" />
              <Skeleton width="90%" height="2rem" />
            </div>
          ) : (
            <>
              {getCustomRouteObjectPreview.map((obj) => {
                return (
                  <a
                    className="text-white inline-block m-4 px-4 py-2 rounded-md hover:scale-105 bg-blue-500"
                    href={obj.path}
                  >
                    {obj.path}
                  </a>
                );
              })}
            </>
            // <DataTable value={getCustomRouteObjectPreview} tableStyle={{ minWidth: "50rem" }}>
            //   <Column field="path" header="Available Endpoints from Router" />
            // </DataTable>
          )}
        </div>
      }
    />
  );
};

export default LandingView;
