SUMMARY = "Python PAM module"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b65882aaede54437e617c55cc8b4fa17"

PYPI_PACKAGE = "python-pam"

inherit pypi python_setuptools_build_meta

DEPENDS += "${PYTHON_PN}-six-native"

SRC_URI[sha256sum] = "97235235ba9b82dbae8068d1099508455949b275f77273ca22fdbd8b1fb5d950"

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-toml \
"
