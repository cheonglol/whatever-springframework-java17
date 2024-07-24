import { Accordion, AccordionTab } from "primereact/accordion";
import { useRouteError } from "react-router-dom";
import { BaseLayout } from "../layouts/BaseLayout";

export const ErrorView = () => {
  const routerError: any = useRouteError();
  console.log(routerError);
  return (
    <BaseLayout
      mainContent={
        <>
          <div className="max-w-[80vw] mx-auto flex flex-col gap-6">
            <h1>We couldn't find the page you were looking for...</h1>
            <h3 className="text-6xl text-center">{routerError.status}</h3>
            <p className="text-center">{routerError.error.message}</p>
            <Accordion className="mx-6">
              <AccordionTab header="Stack Message">
                <code>{routerError.error.stack}</code>
              </AccordionTab>
            </Accordion>
          </div>
        </>
      }
    />
  );
};
