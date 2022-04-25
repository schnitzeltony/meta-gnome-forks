SUMMARY = "The cinnamon-desktop library"
LICENSE = "GPL-2.0-only & LGPL-2.0-only"
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

inherit meson pkgconfig features_check gobject-introspection gettext gsettings

REQUIRED_DISTRO_FEATURES = "x11 pulseaudio"

# gobject-introspection is mandatory and cannot be configured
REQUIRED_DISTRO_FEATURES += "gobject-introspection-data"
GIR_MESON_OPTION = ""

SRC_URI = "git://github.com/linuxmint/cinnamon-desktop.git;branch=master;protocol=https"
SRCREV = "3828f6bcbd4bcbd9f825ec2a9467b310fe0258bc"
PV = "5.2.1"
S = "${WORKDIR}/git"

FILES:${PN} += " \
    ${datadir}/glib-2.0/schemas \
    ${datadir}/libcinnamon-desktop \
"

RDEPENDS:${PN} += " \
    accountsservice \
"
