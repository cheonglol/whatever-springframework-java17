import { render, screen } from "@testing-library/react";
import LandingView from "./view/LandingView";

test("renders learn react link", () => {
  render(<LandingView />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});
