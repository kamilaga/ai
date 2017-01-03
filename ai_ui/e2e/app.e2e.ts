import { MasPage } from './app.po';

describe('mas App', function() {
  let page: MasPage;

  beforeEach(() => {
    page = new MasPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('mas works!');
  });
});
