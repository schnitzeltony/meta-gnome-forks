SUMMARY = "The cinnamon-menu library"
LICENSE = "GPLv2 & LGPLv2"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://COPYING.LIB;md5=5f30f0716dfdd0d91eb439ebec522ec2 \
"

DEPENDS = "gtk+3"

GTKDOC_MESON_OPTION = 'enable_docs'

inherit meson features_check gettext gobject-introspection gtk-doc

REQUIRED_DISTRO_FEATURES = "x11"

# gobject-introspection is mandatory and cannot be configured
REQUIRED_DISTRO_FEATURES += "gobject-introspection-data"
UNKNOWN_CONFIGURE_WHITELIST_append = " introspection"

SRC_URI = "git://github.com/linuxmint/cinnamon-menus.git"
SRCREV = "43b32e785148b6fec07ade208752d70d17c4cbbb"
PV = "4.4.0"
S = "${WORKDIR}/git"


#FILES_${PN} += "${datadir}/desktop-directories/"
