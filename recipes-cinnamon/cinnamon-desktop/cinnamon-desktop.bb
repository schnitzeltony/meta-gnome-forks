SUMMARY = "The cinnamon-desktop library"
LICENSE = "GPLv2 & LGPLv2"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://COPYING.LIB;md5=5f30f0716dfdd0d91eb439ebec522ec2 \
"

DEPENDS = " \
    glib-2.0-native \
    intltool-native \
    gtk+3 \
    libxkbfile \
    pulseaudio \
"

PACKAGECONFIG ?= "alsa"
PACKAGECONFIG[alsa] = "-Dalsa=true,-Dalsa=false,alsa-lib"

inherit meson features_check gobject-introspection gettext gsettings

REQUIRED_DISTRO_FEATURES = "x11 pulseaudio"

# gobject-introspection is mandatory and cannot be configured
REQUIRED_DISTRO_FEATURES += "gobject-introspection-data"
UNKNOWN_CONFIGURE_WHITELIST_append = " introspection"

SRC_URI = "git://github.com/linuxmint/cinnamon-desktop.git"
SRCREV = "7113417186f2c4c8688f313935291daaf7cc2bcd"
PV = "4.4.1"
S = "${WORKDIR}/git"

FILES_${PN} += " \
    ${datadir}/glib-2.0/schemas \
    ${datadir}/libcinnamon-desktop \
"
