# GebToGrid

## tssg branch
The tssg branch contains tests for TSSG Projects.

### Adding a Geb Test Spec to Jenkins
1. Pull [GebToGrid](https://github.com/eaglet3d/GebToGrid/tree/tssg) project from github
   * `git clone https://github.com/eaglet3d/GebToGrid.git`
2. Checkout the tssg branch
   * `git checkout tssg`
3. Confirm that you have the correct branch
   * `git status`
4. Create test source code TSSGMMLoginSpec
5. Confirm that the test runs locally against Selenium Grid with no errors
   * `cd <project home>`
   * `./gradlew firefoxLinuxTest --tests Tests.TSSGMMLoginSpec reportSnaps`
6. In GitHub, create pull request for [GebToGrid branch tssg](https://github.com/eaglet3d/GebToGrid/tree/tssg)
7. In [Jenkins Home Page](http://technologynursery.org:8022/), add job item to run your test inherited from [TSSGMMLoginSpec](http://technologynursery.org:8022/job/TSSGMMLoginSpec/)
   * Select `New Item`
   * Give project a name
   * At botton `Copy From` field, enter `TSSGMMLoginSpec`
   * Reference Configuration for [Project TSSGMMLoginSpec](http://technologynursery.org:8022/job/TSSGMMLoginSpec/).
   ** Go through each field and update as necessary for your test.
8. In [Jenkins Home Page](http://technologynursery.org:8022/), execute build for your project
   * Select `<your new build project name>`
   * Select `Build Now`
