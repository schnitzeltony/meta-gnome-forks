SUMMARY = "The window management library for the Cinnamon desktop"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=8955bdc698cdc995fb6abba2cb6f7347"

DEPENDS = " \
    glib-2.0-native \
    intltool-native \
    gdk-pixbuf-native \
    gnome-doc-utils-stub \
    gtk+3 \
    json-glib \
    libinput \
    cinnamon-desktop \
"

inherit autotools features_check gettext gtk-doc gobject-introspection gsettings

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI = " \
    git://github.com/linuxmint/muffin.git \
    file://0001-Do-not-check-fo-zenity-executable.patch \
    file://0002-fix-warnings-when-compiling.patch  \
    file://gtk-doc.make \
"
SRCREV = "a00332bfd5e437883cdf38dfaa455a4b3448c6e4"
PV = "4.4.2"
S = "${WORKDIR}/git"

EXTRA_OECONF = "--disable-gtk-doc"

do_configure_prepend() {
    cp ${WORKDIR}/gtk-doc.make ${S}/
}

export GIR_EXTRA_LIBS_PATH="${B}/cogl/cogl/.libs:${B}/cogl/cogl-pango/.libs:${B}/cogl/cogl-path/.libs:${B}/clutter/clutter/.libs"

FILES_${PN} += " \
    ${datadir}/glib-2.0/schemas \
"

RDEPENDS_${PN} += "zenity"
