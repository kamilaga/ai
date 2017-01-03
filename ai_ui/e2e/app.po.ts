export class MasPage {
  navigateTo() {
    return browser.get('/');
  }

  getParagraphText() {
    return element(by.css('mas-app h1')).getText();
  }
}
