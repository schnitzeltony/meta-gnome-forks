SUMMARY = "The Mint-Y icon theme"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://debian/copyright;md5=da1b7994399b3b47a019c97f55e4f052"

SRC_URI = "git://github.com/linuxmint/mint-y-icons.git;branch=master;protocol=https"
SRCREV = "36cdc3c1978dfd9d62469fdf8bf641b97742b7a7"
PV = "1.5.9"
S = "${WORKDIR}/git"

inherit allarch gtk-icon-cache

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    cp -r ${S}/usr ${D}
}

FILES:${PN} = "${datadir}/icons"
