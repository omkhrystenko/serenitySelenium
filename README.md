Example of Selenium/Serenity project.




We use manual for install on link https://aerokube.com/selenoid/latest/ there we need to load binary
files first: Configuration Manager (link https://github.com/aerokube/cm/releases/tag/1.6.0) to Selenoid
Selenoid is a kind of Selenium Hub (separate utility for selenium that allows you to work remotely).
(F.e. Selenium hub is installed on separate server with linux and gives us its URL and port, and using
this data in driver properties on our computer we can run tests on selenium hub server from our computer
with Windows). Selenium hub gives us opportunity to divide code and browsers to separate computers.

Docker allows you to implement different OS virtual machines on the server where selenium hub was installed.
G.G.R. (kind of Selenoid for launching on CMD project)
