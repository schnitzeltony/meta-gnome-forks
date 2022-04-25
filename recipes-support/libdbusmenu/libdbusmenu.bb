SUMMARY = "Library for passing menus over DBus"
LICENSE = "LGPL-3.0-only & LGPL-2.1-only & GPL-3.0-only"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=6a6a8e020838b23406c81b19c1d46df6 \
    file://COPYING.2.1;md5=2d5025d4aa3495befef8f17206a5b0a1 \
    file://COPYING-GPL3;md5=f27defe1e96c2e1ecd4e0c9be8967949 \
"

DEPENDS = " \
    glib-2.0-native \
    intltool-native \
    dbus \
    gtk+ \
    gtk+3 \
    json-glib \
"

inherit autotools pkgconfig gobject-introspection gtk-doc gettext

PV = "16.04.0"
SHRT_VER = "${@oe.utils.trim_version("${PV}", 2)}"

SRC_URI = " \
    https://launchpad.net/libdbusmenu/${SHRT_VER}/${PV}/+download/${BPN}-${PV}.tar.gz \
    file://0001-Remove-Werror.patch \
"
SRC_URI[sha256sum] = "b9cc4a2acd74509435892823607d966d424bd9ad5d0b00938f27240a1bfa878a"

do_compile:prepend() {
    export GIR_EXTRA_LIBS_PATH="${B}/libdbusmenu-glib/.libs"
}

