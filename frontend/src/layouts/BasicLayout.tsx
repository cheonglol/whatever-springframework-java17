interface Props {
  headerContent?: any | undefined;
  mainContent: any;
  footerContent?: any;
  includesBottomNav?: boolean;
}

export const BasicLayout = ({
  headerContent,
  mainContent,
  footerContent,
}: Props) => {
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
    <>
      {header}
      <main className="py-8 px-[4vw] min-h-screen ">{mainContent}</main>
      {footer}
    </>
  );
};
