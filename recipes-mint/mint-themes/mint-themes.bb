SUMMARY = "Mint themes"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://debian/copyright;md5=ef6979a180ddd4e4bda4513c8a9dc47b"

SRC_URI = "git://github.com/linuxmint/mint-themes.git;branch=master;protocol=https"
SRCREV = "447703b2c08c9b632736be559fa47a6caa04d072"
PV = "1.9.6"
S = "${WORKDIR}/git"

DEPENDS = " \
    sassc-native \
"

inherit allarch

do_configure[noexec] = "1"

do_install() {
    cp -r ${S}/usr ${D}
}

FILES:${PN} = "${datadir}/themes"
