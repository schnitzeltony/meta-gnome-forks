SUMMARY = "Python3 Xapp Library"
LICENSE = "LGPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=f30a9716ef3762e3467a2f62bf790f0a"

inherit setuptools3

SRC_URI = "git://github.com/linuxmint/python3-xapp.git;branch=master;protocol=https"
SRCREV = "7498934c4eb8da341ae782bf4fa6b8219866d7e1"
PV = "2.2.1"
S = "${WORKDIR}/git"

RDEPENDS:${PN} += " \
    libxapp-python3 \
"
