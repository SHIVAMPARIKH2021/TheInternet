TimeOut Exception in Selenium:
StackOverFlow: https://stackoverflow.com/questions/48450594/selenium-timed-out-receiving-message-from-renderer

Root cause: Whenever you are loading some page with the help of selenium driver,  then driver script wait till page is completely loaded. But sometime webdriver takes more time to load page, in that case you will see TimeoutException exception in your console.

Solution: When Page Loading takes too much time for wait so we will wait for the DOMContentLoaded event with page load strategy. This page load strategy is called Eager. A small definition of available all 3 pageload strategies.

1. normal: This strategy causes Selenium to wait for the full page loading (html content and sub resources downloaded and parsed).

2. eager : This strategy causes Selenium to wait for the DOMContentLoaded event (html content downloaded and parsed only).

3. none : This strategy causes Selenium to return immediately after the initial page content is fully received (html content downloaded).

NOTE : By default, when Selenium loads a page, it follows the normal pageLoadStrategy.