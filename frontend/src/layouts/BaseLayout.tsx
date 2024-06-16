interface Props {
  headerContent?: any | undefined;
  mainContent: any;
  footerContent?: any;
  useCard?: boolean;
}

export const BaseLayout = ({ headerContent, mainContent, footerContent, useCard = true }: Props) => {
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
