interface Props {
  headerContent?: any | undefined;
  mainContent: any;
  footerContent?: any;
}

export const Flex3ColLayout = ({ headerContent, mainContent, footerContent }: Props) => {
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
      <main className="py-12 px-[4vw] min-h-screen ">{mainContent}</main>
      {footer}
    </div>
  );
};
