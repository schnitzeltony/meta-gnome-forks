SUMMARY = "A tiny CSS parser"
HOMEPAGE = "https://www.courtbouillon.org/tinycss2"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1d072d7e30e34f33f8ae956ada04fa2c"

inherit pypi python_setuptools_build_meta

#DEPENDS += "${PYTHON_PN}-six-native"

SRC_URI[sha256sum] = "b2e44dd8883c360c35dd0d1b5aad0b610e5156c2cb3b33434634e539ead9d8bf"

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-webencodings \
"
