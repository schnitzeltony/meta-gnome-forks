SUMMARY = "GNOME Authentication Agent for PolicyKit"
LICENSE = "LGPL-2.0-or-later"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=74579fab173e4c5e12aac0cd83ee98ec \
    file://src/main.c;beginline=1;endline=20;md5=aba145d1802f2329ba561e3e48ecb795 \
"

DEPENDS = " \
    intltool-native \
    glib-2.0-native \
    polkit \
    gtk+3 \
    gnome-common \
"

inherit autotools pkgconfig gtk-doc features_check

REQUIRED_DISTRO_FEATURES = "x11 polkit"

SRC_URI = " \
    git://gitlab.gnome.org/Archive/policykit-gnome.git;branch=master;protocol=https \
    file://gtk-doc-check.patch \
"
SRCREV = "a0763a246a81188f60b0f9810143e49224dc752f"
S = "${WORKDIR}/git"
PV = "0.105+git${SRCPV}"
