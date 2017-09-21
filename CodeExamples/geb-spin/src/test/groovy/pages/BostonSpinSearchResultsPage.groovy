package pages

import pages.BostonSpinHomePage

/*
 * Home page for the Boston SPIN web site.
 */

class BostonSpinSearchResultsPage extends BostonSpinHomePage {

    static at = {
        title.startsWith("Search Results for ")
    }

    static content = {
        searchResults(required:false) { $("#content div h2") }
    }
}
