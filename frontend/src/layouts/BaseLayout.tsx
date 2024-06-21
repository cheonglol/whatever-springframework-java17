import { memo } from "react";
import RouterEndpointsNav from "../components/RouterEndpointsNav";

const MRouterEndpointNav = memo(RouterEndpointsNav);

interface Props {
  headerContent?: any | undefined;
  mainContent: any;
  footerContent?: any;
  useCard?: boolean;
  showNav?: boolean;
}

export const BaseLayout = ({ headerContent, mainContent, footerContent, useCard = true, showNav = true }: Props) => {
  const header = (
    <>
      <header className="py-4">{headerContent ? headerContent : <></>}</header>
    </>
  );

  const footer = (
    <>
      <footer className="py-4">{footerContent ? footerContent : <></>}</footer>
    </>
  );

  return (
    <div>
      {header}
      <main className={`min-h-screen py-12 px-[4vw]`}>
        {showNav ? (
          <div className="mb-10">
            <em className="font-light text-sm">Endpoints Available:</em>
            <br />
            <MRouterEndpointNav />
          </div>
        ) : (
          <></>
        )}
        {useCard ? (
          <div className="shadow-xl bg-slate-100 px-6 py-8 min-h-[66vh] font-medium">{mainContent}</div>
        ) : (
          mainContent
        )}
      </main>
      {footer}
    </div>
  );
};
