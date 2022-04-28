SUMMARY = "Linux Mint 20.3 Una backgrounds"
LICENSE = "Unsplash"
LIC_FILES_CHKSUM = "file://backgrounds/linuxmint-una/Credits;md5=b57930efd035b5a6e206ed403c305d89"

SRC_URI = "http://packages.linuxmint.com/pool/main/m/${BPN}/${BPN}_${PV}.tar.gz"
SRC_URI[sha256sum] = "42a8af8c7f18bb83743ba31ee6c2d74ba9328bbac2d28399a7218991400a6e9c"
S = "${WORKDIR}/${BPN}"

inherit allarch

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${datadir}
    cp -r ${S}/backgrounds ${D}/${datadir}
    cp -r ${S}/cinnamon-background-properties ${D}/${datadir}
}

FILES:${PN} = " \
    ${datadir}/backgrounds \
    ${datadir}/cinnamon-background-properties \
"
