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

# 0002-0006 were taken from https://src.fedoraproject.org/rpms/polkit-gnome/tree/rawhide
SRC_URI = " \
    git://gitlab.gnome.org/Archive/policykit-gnome.git;branch=master;protocol=https \
    file://0001-gtk-doc-check.patch \
    file://0002-select-default-user.patch \
    file://0003-autorestart.patch \
    file://0004-use-accountsservice.patch \
    file://0005-fresh-x11-timestamps.patch \
    file://0006-auth-dialog-make-the-label-wrap-at-70-chars.patch \
"
SRCREV = "a0763a246a81188f60b0f9810143e49224dc752f"
S = "${WORKDIR}/git"
PV = "0.105+git${SRCPV}"
