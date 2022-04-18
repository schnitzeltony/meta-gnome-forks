SUMMARY = "GNOME keyboard configuration library"
LICENSE = "LGPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=6e29c688d912da12b66b73e32b03d812"

DEPENDS = " \
    gtk+3 \
    libxklavier \
"

inherit gnomebase gobject-introspection gsettings gettext features_check 

ANY_OF_DISTRO_FEATURES = "${GTK3DISTROFEATURES}"

SRC_URI[archive.sha256sum] = "f7ca02631576e9b88aee1b1bae37ac1488b80ee7975f20a97f29e761a7172679"

