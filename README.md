# :camera: :boom:
# Demo Project: Android Screenshot Testing

This project is a demo for my bachelor's thesis defense on Android screenshot testing.
The tool of choice is Roborazzi. Git LFS is used for storing and versioning screenshots.
The screenshot tests also run in the CI/CD pipeline. Check the commits to see the pipeline
failing when a UI regression is introduced.

### What to look for

`SettingsItemTest` and `SettingsScreenTest` represent a low-level screenshot test and a
screen-level screenshot test respectively. The reference screenshots are stored under
`app/roborazzi/references`. The integration into the CI/CD workflow can be seen in `check.yml`.
