SUMMARY = "The Cinnamon screen locker and screensaver program"
LICENSE = "GPL-2.0-only & LGPL-2.0-only"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=0b9285731f87837aeb321c2dfb857951 \
    file://COPYING.LIB;md5=59b5d7f7b4987b5ecf9ffef011d9ed05 \
"

DEPENDS = " \
    gtk+3 \
    virtual/libx11 \
    libxinerama \
"

#  gsettings
inherit meson pkgconfig gobject-introspection gtk-icon-cache features_check

REQUIRED_DISTRO_FEATURES += "x11 pam"

# gobject-introspection is mandatory and cannot be configured
REQUIRED_DISTRO_FEATURES += "gobject-introspection-data"
GIR_MESON_OPTION = ""

SRC_URI = "git://github.com/linuxmint/cinnamon-screensaver.git;branch=master;protocol=https"
SRCREV = "2d0df7841ad996303732619fbeb65b782c07e887"
PV = "5.2.1"
S = "${WORKDIR}/git"

FILES:${PN} += "${datadir}/dbus-1"

RDEPENDS:${PN} += " \
    accountsservice \
    cinnamon-desktop \
    libgnomekbd \
    python3-core \
    python3-pygobject \
    python3-setproctitle \
    python3-xapp \
"
