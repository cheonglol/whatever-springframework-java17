import { Skeleton } from "primereact/skeleton";
import { useEffect, useState } from "react";
import { RouteObject } from "react-router-dom";

const RouterEndpointsNav = () => {
  const [getCustomRouteObjectPreview, setCustomRouteObjectPreview] = useState<RouteObject[]>([]);

  useEffect(() => {
    const loadRoutes = async () => {
      const awaitedImport = await import("../router/Router");
      setCustomRouteObjectPreview(awaitedImport.myRouteObjects);
    };
    if (getCustomRouteObjectPreview.length === 0) loadRoutes();
  }, [getCustomRouteObjectPreview]);

  return (
    <>
      {getCustomRouteObjectPreview.length === 0 ? (
        <div className="mt-4 flex-col space-y-4">
          {/* Corrected usage of Skeleton */}
          <Skeleton width="80%" height="4rem" />
          <Skeleton width="90%" height="2rem" />
        </div>
      ) : (
        getCustomRouteObjectPreview.map((obj) => (
          <a
            className="text-white text-sm inline-block mx-[0.25rem] px-4 py-[0.125rem] rounded-md bg-blue-600 hover:scale-[104%] hover:bg-blue-900 w-fit transition-all"
            href={obj.path}
          >
            {obj.path}
          </a>
        ))
      )}
    </>
  );
};

export default RouterEndpointsNav;
