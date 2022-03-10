SUMMARY = "The cinnamon-menu library"
LICENSE = "GPL-2.0-only & LGPL-2.0-only"
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
GIR_MESON_OPTION = ""

SRC_URI = "git://github.com/linuxmint/cinnamon-menus.git;branch=master;protocol=https"
SRCREV = "1d7cb63f333c2b97c9fcd09c8303c4c5a7f9200e"
PV = "5.2.0"
S = "${WORKDIR}/git"
