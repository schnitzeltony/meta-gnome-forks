SUMMARY = "Icon theme for Linux Mint"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://debian/copyright;md5=074a31b45e413222ab4a4ed4edceef64"

SRC_URI = "git://github.com/linuxmint/mint-x-icons.git;branch=master;protocol=https"
SRCREV = "4ab3c314db1b3751d87d5769629b28ac0ca3c671"
PV = "1.6.4"
S = "${WORKDIR}/git"

inherit allarch gtk-icon-cache

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    cp -r ${S}/usr ${D}
}

FILES:${PN} = "${datadir}/icons"
